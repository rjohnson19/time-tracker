import { combineReducers } from "redux";
import { Action } from "redux-actions";
import { ADD_ENTRIES } from "./constants/ActionTypes";
import { ITimeEntry } from "./Types";

const entriesReducer = (
  state: ITimeEntry[] = [],
  action: Action<ITimeEntry[]>
) => {
  switch (action.type) {
    case ADD_ENTRIES:
      return action.payload;
    default:
      return state;
  }
};

export const rootReducer = combineReducers({ entries: entriesReducer });
