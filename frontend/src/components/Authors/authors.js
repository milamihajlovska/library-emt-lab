import React from "react";
import BookTerm from "../Books/BookTerm/bookTerm";

const authors = (props) =>{
    return(
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            {/*<th scope={"col"}>Category</th>*/}
                            {/*<th scope={"col"}>Author</th>*/}
                            {/*<th scope={"col"}>Copies</th>*/}
                        </tr>

                        </thead>
                        <tbody>
                        {props.authors.map((term)=>{
                            return (

                                <tr>
                                    <td>{term.name}</td>
                                    {/*<td>{term.availableCopies}</td>*/}

                                </tr>
                            );
                        })}
                        </tbody>

                    </table>

                </div>

            </div>

        </div>
    );
}

export default authors;