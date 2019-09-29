import React from 'react';
import SearchResult from './SearchResult';

class SearchResults extends React.Component {
  render() {
    if (this.props.searchResults.length === 0 && this.props.numSearches <= 0) {
      return null;
    }

    if (this.props.searchResults.length === 0 && this.props.numSearches >= 1) {
      return (
        <div className="Search-results">
          <h3>No animal has said that yet.</h3>
        </div>
      );
    }

    let searchResultList = this.props.searchResults.map((result) => (
      <SearchResult key={result} searchResult={result}></SearchResult>
    ));

    return (
      <div className="Search-results">
        <h3>Said the...</h3>
        <ul>{searchResultList}</ul>
      </div>
    );
  }
}

export default SearchResults;
