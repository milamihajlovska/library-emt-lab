import React from "react";
import BookTerm from "../BookTerm/BookTerm";
import {Link} from "react-router-dom";
import ReactPaginate from "react-paginate";

class Books extends React.Component{
    constructor(props) {
        super(props);

        this.state={
            page: 0,
            size: 2
        }
    }

    render() {

        const offset= this.state.size * this.state.page;
        const nextPageOffset =offset + this.state.size;
        const pageCount=Math.ceil(this.props.books.length / this.state.size);
        const books =this.getBooksPage(offset,nextPageOffset);

        return(
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"row"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Category</th>
                                <th scope={"col"}>Author</th>
                                <th scope={"col"}>Copies</th>
                            </tr>

                            </thead>
                            <tbody>
                            {/*{this.props.books.map((term)=>{*/}
                            {/*    return (*/}
                            {/*        <BookTerm term={term} onDelete={this.props.onDelete}*/}
                            {/*                  onEdit={this.props.onEdit}/>*/}
                            {/*        // <tr>*/}
                            {/*        //     <td>{term.name}</td>*/}
                            {/*        //     /!*<td>{term.availableCopies}</td>*!/*/}
                            {/*        //*/}
                            {/*        // </tr>*/}
                            {/*    );*/}
                            {/*})}*/}

                            {books}

                            </tbody>

                        </table>

                    </div>


                    <div className={"col mb-3"}>
                        <div className={"row"}>
                            <div className={"col-sm-12 col-md-12"}>
                                <Link className={"btn btn-block btn-dark"} to={"/books/add"}>
                                    Add New Book
                                </Link>
                            </div>
                        </div>
                    </div>

                </div>
                <ReactPaginate previousLabel={"back"}
                               nextLabel={"next"}
                               breakLabel={<a href={"/#"}>...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}

                />
            </div>
        );
    }

    handlePageClick = (data) =>{
        let selected=data.selected;
        this.setState({
            page: selected
        })
    }
    getBooksPage = (offset,nextPageOffset ) =>
    {
       return this.props.books.map((term) => {
            return(
                <BookTerm term={term} onDelete={this.props.onDelete}
                          onMark={this.props.onMark}
                          onEdit={this.props.onEdit}/>
            );
        }).filter((book,index) => {
            return index >=offset && index < nextPageOffset;
        })
    }
}



export default Books;