import React from "react";
import {Link} from "react-router-dom";

const bookTerm = (props) =>{
    return(
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author.name}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            {/*<td scope={"col"}>{props.term.bookId}</td>*/}

            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.bookId)}>
                    Delete</a>
            </td>
            <td className={"text-left"}>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.bookId)}
                      to={`/books/edit/${props.term.bookId}`}>Edit</Link>
            </td>
            <td className={"text-left"}>
                <a title={"Mark"} className={"btn btn-info"}
                   onClick={() => props.onMark(props.term.bookId)}>Mark As Taken</a>
            </td>
        </tr>

    );
}
export default bookTerm;