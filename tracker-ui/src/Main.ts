import { connect } from "react-redux";
import App from "./App";
import { AppState } from "./Types.js";

const mapStateToProps = (state: AppState) => {
  return {
    entries: state.entries
  };
};

const Main = connect(mapStateToProps)(App);

export default Main;
