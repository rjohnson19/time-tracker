import { AnyAction, Dispatch } from "redux";

export interface IProject {
  id: number;
  name: string;
}

export interface ITimeEntry {
  id?: number;
  description: string;
  startTime: Date;
  endTime?: Date;
  project?: IProject;
}

export interface IProps {
    entries: ITimeEntry[],
    dispatch: Dispatch<AnyAction>
}

// App state

const emptyEntries: ITimeEntry[] = [];
export const initialState = { entries: emptyEntries };
export type AppState = Readonly<typeof initialState>;