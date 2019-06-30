import React from 'react';

class SearchBar extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      inputValue: "",
    };
  }

  render() {
    return (
      <div>
        <h2>Search</h2>
        <input onChange={this.onChangeInput} type='text' placeholder='Of course'></input>
        <button onClick={this.onClickSearch}>Search</button>
      </div>
    );
  }

  onChangeInput = (event) => { 
    this.setState({
      inputValue: event.target.value,
    });
  }

  onClickSearch = (event) => {
    this.props.onClickSearchCallback(this.state.inputValue);
  }
}

export default SearchBar;