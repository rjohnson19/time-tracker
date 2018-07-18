import { createAction } from "redux-actions";
import { ADD_ENTRIES } from "./constants/ActionTypes";
import { ITimeEntry } from "./Types";

/**
 * Action creator for adding time entries.
 */
export const addEntries = createAction<ITimeEntry[], ITimeEntry[]>(
  ADD_ENTRIES,
  (entries: ITimeEntry[]) => entries
);
