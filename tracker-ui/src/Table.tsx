import * as React from "react";
import { ITimeEntry } from "./Types";

interface ITableProps {
  entries: ITimeEntry[];
}

class Table extends React.Component<ITableProps, object> {
  public renderEntry(entry: ITimeEntry, index: number) {
    let projectLine = <span />;
    if (entry.project) {
      projectLine = (
        <span>
          <strong>Project:</strong> {entry.project.name}
        </span>
      );
    }
    return (
      <div className="entry" key={index}>
        <span className="entry-desc">{entry.description}</span>
        <strong>Start:</strong> {entry.startTime}
        <strong>End:</strong> {entry.endTime}
        {projectLine}
      </div>
    );
  }
  public render() {
    const { entries } = this.props;
    return <div className="table">{entries.map(this.renderEntry)}</div>;
  }
}

export default Table;
