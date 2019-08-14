import React from "react";

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
        <form onSubmit={this.onClickSearch}>
          <input
            onChange={this.onChangeInput}
            type="text"
            placeholder="Of course"
            autoFocus
          ></input>
          <input type="submit" value="Search" />
        </form>
      </div>
    );
  }

  onChangeInput = event => {
    this.setState({
      inputValue: event.target.value,
    });
  };

  onClickSearch = event => {
    event.preventDefault();
    this.props.onClickSearchCallback(this.state.inputValue);
  };
}

export default SearchBar;
