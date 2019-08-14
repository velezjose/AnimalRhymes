import React from "react";
import SearchResult from "./SearchResult";

class SearchResults extends React.Component {
  render() {
    if (this.props.searchResults.length === 0) {
      return null;
    }
    let searchResultList = this.props.searchResults.map(result => (
      <SearchResult key={result} searchResult={result}></SearchResult>
    ));
    return (
      <div className="Search-results">
        <h3>Results</h3>
        <ul>{searchResultList}</ul>
      </div>
    );
  }
}

export default SearchResults;
