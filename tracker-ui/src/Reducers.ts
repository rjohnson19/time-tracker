import { combineReducers } from "redux";
import { Action } from "redux-actions";
import { ADD_ENTRIES } from "./constants/ActionTypes";
import { ITimeEntry } from "./Types";

/**
 * Reducer for entries action, specifically adding them when we get them from the API.
 * @param state The array of time entries.
 * @param action The action being handled.
 */
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
