export interface IProject {
  id: number;
  name: string;
}

export interface ITimeEntry {
  id: number;
  description: string;
  startTime: Date;
  endTime: Date;
  project: IProject;
}
