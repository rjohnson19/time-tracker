import axios from "axios";
import * as React from "react";
import { addEntries } from "./ActionCreators";
import "./App.css";
import logo from "./logo.svg";
import Table from "./Table";
import { IProps, ITimeEntry } from "./Types";

const RECENT_ENTRIES_PATH = "/entries/recent";
const API_USERNAME = "user";
const API_PASSWORD = "trackeruser";

class App extends React.Component<IProps> {
  public render() {
    const { entries } = this.props;
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Time Tracker</h1>
        </header>

        <Table entries={entries} />
      </div>
    );
  }

  public componentDidMount() {
    this.fetchRecentEntries();
  }

  private fetchRecentEntries() {
    axios
      .get(RECENT_ENTRIES_PATH, {
        auth: {
          password: API_PASSWORD,
          username: API_USERNAME
        }
      })
      .then(result => this.handleEntries(result.data))
      // TODO: proper error handling
      // tslint:disable-next-line:no-console
      .catch(error => console.log(error));
  }

  private handleEntries(entries: ITimeEntry[]) {
    const { dispatch } = this.props;
    dispatch(addEntries(entries));
  }
}

export default App;
