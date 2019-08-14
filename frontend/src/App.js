import React from 'react';
import './App.css';

import Navbar from './components/Navbar';
import SearchRoot from './components/SearchRoot';
import { MockRhymeRepository } from './repositories/MockRhymeRepository';
import { DevelopmentRhymeRepository } from './repositories/DevelopmentRhymeRepository';

// TODO(ak): support process.env.NODE_ENV === "production".
const getRhymeRepositoryForEnvorinment = () =>{ 
  const nodeEnv = process.env.NODE_ENV;
  if (nodeEnv === "test") {
    return new MockRhymeRepository();
  } else if (nodeEnv === "development") {
    return new DevelopmentRhymeRepository();
  } else {
    throw new Error(`Couldn't get rhyme repository for unrecognized node environment ${nodeEnv}.`);
  }
}
const rhymeRepository = getRhymeRepositoryForEnvorinment();

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
