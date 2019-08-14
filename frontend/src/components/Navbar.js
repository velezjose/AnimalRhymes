import React from 'react';

import horsePic from '../assets/horse.png';

class Navbar extends React.Component {
  render() {
    let horsePicStyle = {
      width: '50px',
    };
    let flipImageStyle = {
      transform: 'scaleX(-1)',
    };
    let reverseHorsePicStyle = Object.assign({}, horsePicStyle, flipImageStyle);
    return (
      <div className="navbar">
        <img src={horsePic} alt="horse" style={horsePicStyle}></img>
        <h2>Animal Rhymes</h2>
        <img src={horsePic} alt="horse" style={reverseHorsePicStyle}></img>
      </div>
    );
  }
}

export default Navbar;
