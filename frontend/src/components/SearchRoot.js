import React from 'react';
import SearchBar from './SearchBar';
import SearchResults from './SearchResults';

class SearchRoot extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      searchResults: [],
      numSearches: 0,
    };
  }

  render() {
    return (
      <div>
        <SearchBar
          onClickSearchCallback={this.onClickSearchCallback}
        ></SearchBar>
        <SearchResults
          searchResults={this.state.searchResults}
          numSearches={this.state.numSearches}
        ></SearchResults>
      </div>
    );
  }

  onClickSearchCallback = async (query) => {
    let searchResults = await this.props.rhymeRepository.getRhymes(query);

    console.log(
      `searched for ${query}, got ${JSON.stringify(searchResults, null, 2)}`
    );

    this.setState({
      searchResults,
      numSearches: this.state.numSearches + 1,
    });
  };
}

export default SearchRoot;
