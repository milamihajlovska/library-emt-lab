import axios from '..//custom-axios/axios';

const LibraryService={
    fetchBooks:()=>{
        return axios.get("/books");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchAuthors: () => {
        return axios.get("/authors");
    }
}

export default LibraryService;