import React from 'react';
import './App.css';

import Search from './components/Search';
import Navbar from './components/Navbar';

function App() {
  return (
    <div classNamee="App">
      <Navbar></Navbar>
      <div className="App-header">
        <Search></Search>
      </div>
    </div>
  );
}

export default App;
