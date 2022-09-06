import react from 'react';
import { Link } from "react-router-dom";

import '../styles/navbar.css';

class Navbar extends React.Component {
    constructor(props) {
        super(props)
        
    }

    activateNav() {
        const navbarLinks = document.getElementsByClassName('nav-menu')[0];

        navbarLinks.classList.toggle('active');
    }

    render() {
        return (
            <nav className='navbar'>
                <div className='navbar-logo'>

                </div>

                <button className='toggle-btn' onClick={this.activateNav}>
                    <span className='bar'></span>
                    <span className='bar'></span>
                    <span className='bar'></span>
                    <span className='bar'></span>
                </button>

                <div className='navbar-links'>
                    <ul>
                        <li>
                            <Link to='/'>Home</Link>
                        </li>
                        <li>

                        </li>
                        <li>

                        </li>
                        <li>

                        </li>
                    </ul>
                </div>
            </nav>
        )
    }
}

export default Navbar;