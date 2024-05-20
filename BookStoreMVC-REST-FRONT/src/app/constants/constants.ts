// export const host: string = "http://localhost";
// export const host: string = "http://192.168.239.39";
// export const port: number = 8080;
// export const url: string = `${host}:${port}/`;
import * as process from "node:process";
import {environment} from "../../environment/environment";

export const url: string = environment.apiHost;
export const authorsImagesPath: string = "authors/image/";
export const booksImagesPath: string = "books/image/";
export const usersImagesPath: string = "users/image/";

export const millisecondsInYear: number = 1000 * 60 * 60 * 24 * 365;

export const defaultMaxUploadFileSize: number = 1048576;
