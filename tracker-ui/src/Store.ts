import { createStore } from "redux";
import { initialState } from "./Types";

import { rootReducer } from "./Reducers";

const store = createStore(rootReducer, initialState);

export default store;
