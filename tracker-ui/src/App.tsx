import axios from "axios";
import * as React from "react";

import "./App.css";

import Table from "./Table";
import { ITimeEntry } from "./Types";

import logo from "./logo.svg";

type State = Readonly<typeof initialState>;

const RECENT_ENTRIES_PATH = "/entries/recent";
const API_USERNAME = "user";
const API_PASSWORD = "trackeruser";
const emptyEntries: ITimeEntry[] = [];
const initialState = { entries: emptyEntries };

class App extends React.Component<object, State> {
  public readonly state: State = initialState;
  public render() {
    const {entries} = this.state;
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
    this.setState(setEntries(entries));
  }
}

const setEntries = (entries: ITimeEntry[]) => (prevState: State) => ({
  entries
});

export default App;
