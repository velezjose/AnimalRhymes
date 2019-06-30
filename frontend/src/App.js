import React from 'react';
import './App.css';

import Navbar from './components/Navbar';
import SearchRoot from './components/SearchRoot';
import { MockRhymeRepository } from './repositories/MockRhymeRepository';

const rhymeRepository = new MockRhymeRepository();

function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      <div className="App-header">
        <SearchRoot rhymeRepository={rhymeRepository}></SearchRoot>
      </div>
    </div>
  );
}

export default App;
