import * as React from "react";
import * as ReactDOM from "react-dom";
import { Provider } from "react-redux";
import "./index.css";
import Main from "./Main";
import registerServiceWorker from "./registerServiceWorker";
import store from "./Store";

const provider = (
  <Provider store={store}>
    <Main />
  </Provider>
);

ReactDOM.render(provider, document.getElementById("root") as HTMLElement);
registerServiceWorker();
