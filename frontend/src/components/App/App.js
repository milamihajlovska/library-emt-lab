import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Routes, Redirect, Route} from "react-router-dom";

import {Navigate} from 'react-router-dom';
import LibraryService from "../../repository/libraryRepository";
import Categories from "../Categories/categories";
import Header from "../Header/header";
import Authors from "../Authors/authors";
import Books from "../Books/BookList/Books";
import BookAdd from "../Books/BookAdd/BookAdd"
import BookEdit from "../Books/BookEdit/BookEdit";
class App extends Component
{
  constructor(props) {
    super(props);
    this.state={
        books: [],
        categories: [],
        authors:[],
        selectedBook:{}
    }
  }
  render() {
    return(
      <Router>
          <Header/>
          <main>
              <div className={"container"}>

                  <Routes>
                      <Route path={"/books/edit/:id"} element={<BookEdit
                      categories={this.state.categories}
                      authors={this.state.authors}
                      onEditBook={this.editBook}
                      book={this.state.selectedBook}
                  />}/>

                      <Route path={"/books/add"} element={<BookAdd categories={this.state.categories}
                                                                   authors={this.state.authors}
                                                                   onAddBook={this.addBook}/>}/>

                      <Route path={"/books"} element={<Books books={this.state.books}
                                                             onDelete={this.deleteBook}
                                                             onEdit={this.getBook}
                                                             onMark={this.markBook}
                      />}/>
                      {/*<Route path={"/books"} exact render={() => <Books books={this.state.books}/>}/>*/}
                      <Route path={"/categories"} element={<Categories categories={this.state.categories}/>}/>
                      <Route path={"/authors"}  element={<Authors authors={this.state.authors} />}/>

                      {/*<Redirect to={"/books"}/>*/}
                  </Routes>

              </div>
          </main>

      </Router>
    );
  }

  loadBooks=()=>{
    LibraryService.fetchBooks()
        .then((data)=> {
          this.setState({
            books: data.data
          })
        });
  }
    loadCategories=()=>{
        LibraryService.fetchCategories()
            .then((data)=> {
                this.setState({
                    categories: data.data
                })
            });
    }
    loadAuthors=()=>{
        LibraryService.fetchAuthors()
            .then((data)=> {
                this.setState({
                    authors: data.data
                })
            });
    }

    deleteBook = (id)=>{
      LibraryService.deleteBook(id)
          .then(() => {
              this.loadBooks();
          });
    }
    addBook = (name,category, author, availableCopies) =>
    {
        LibraryService.addBook(name,category,author,availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook =(id) =>
    {
        LibraryService.getBook(id)
            .then((data) => {
               this.setState({
                   selectedBook:data.data
               })
            });
    }

    editBook = (id,name,category, author, availableCopies) =>
    {
        LibraryService.editBook(id,name,category, author, availableCopies)
            .then(()=> {
                this.loadBooks();
            });
    }
    markBook = (id) =>{
        LibraryService.markBook(id)
            .then(()=>{
                this.loadBooks();
            });
    }
    componentDidMount() {
    this.loadBooks();
    this.loadCategories();
    this.loadAuthors();
  }
}

export default App;
