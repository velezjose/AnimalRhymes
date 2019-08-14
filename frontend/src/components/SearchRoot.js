import React from "react";
import SearchBar from "./SearchBar";
import SearchResults from "./SearchResults";

class SearchRoot extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      searchResults: [],
    };
  }

  render() {
    return (
      <div>
        <SearchBar
          onClickSearchCallback={this.onClickSearchCallback}
        ></SearchBar>
        <SearchResults searchResults={this.state.searchResults}></SearchResults>
      </div>
    );
  }

  onClickSearchCallback = async query => {
    let searchResults = await this.props.rhymeRepository.getRhymes(query);
    console.log(
      `searched for ${query}, got ${JSON.stringify(searchResults, null, 2)}`
    );
    this.setState({
      searchResults: searchResults,
    });
  };
}

export default SearchRoot;
