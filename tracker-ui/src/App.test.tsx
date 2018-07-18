import * as React from 'react';
import * as ReactDOM from 'react-dom';
import { AnyAction, Dispatch } from '../node_modules/redux';
import App from './App';
import { ITimeEntry } from './Types';

it('renders without crashing', () => {
  const div = document.createElement('div');
  const entries: ITimeEntry[] = [];
  const dispatch: Dispatch<AnyAction> = jest.fn();
  ReactDOM.render(<App entries={entries} dispatch={dispatch} />, div);
  ReactDOM.unmountComponentAtNode(div);
});
