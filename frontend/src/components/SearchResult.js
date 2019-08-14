import React from "react";

class SearchResult extends React.Component {
  render() {
    return <li className="Search-result">{this.props.searchResult}</li>;
  }
}

export default SearchResult;
