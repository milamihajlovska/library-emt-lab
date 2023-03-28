import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Routes, Redirect, Route} from "react-router-dom";

import {Navigate} from 'react-router-dom';
import LibraryService from "../../repository/libraryRepository";
import Categories from "../Categories/categories";
import Header from "../Header/header";
import Authors from "../Authors/authors";
import Books from "../Books/BookList/books";

class App extends Component
{
  constructor(props) {
    super(props);
    this.state={
        books: [],
        categories: [],
        authors:[]
    }
  }
  render() {
    return(
      <Router>
          <Header/>
          <main>
              <div className={"container"}>

                  <Routes>
                      <Route path={"/books"} element={<Books books={this.state.books}/>}/>
                      {/*<Route path={"/books"} exact render={() => <Books books={this.state.books}/>}/>*/}
                      <Route path={"/categories"} element={<Categories categories={this.state.categories}/>}/>
                      <Route path={"/authors"}  element={<Authors authors={this.state.authors}/>}/>

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


    componentDidMount() {
    this.loadBooks();
    this.loadCategories();
    this.loadAuthors();
  }
}

export default App;
