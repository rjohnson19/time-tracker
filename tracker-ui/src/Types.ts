import { AnyAction, Dispatch } from "redux";

/**
 * Interface for the Project type.
 */
export interface IProject {
  id: number;
  name: string;
}

/**
 * Interface for the TimeEntry type.
 */
export interface ITimeEntry {
  id?: number;
  description: string;
  startTime: Date;
  endTime?: Date;
  project?: IProject;
}

/**
 * Interface for props common to app components.
 */
export interface IProps {
    entries: ITimeEntry[],
    dispatch: Dispatch<AnyAction>
}

// App state

const emptyEntries: ITimeEntry[] = [];
export const initialState = { entries: emptyEntries };
export type AppState = Readonly<typeof initialState>;