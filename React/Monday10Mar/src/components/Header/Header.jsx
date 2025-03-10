import { NavLink } from "react-router-dom";
import "./Header.css";

function Header() {
  const navItems = [
    { name: "Courses", path: "/courses" },
    { name: "Best Selling", path: "/best-selling" },
    { name: "About Us", path: "/about-us" },
    { name: "Plans & Pricing", path: "/plans-pricing" },
    { name: "Feedback", path: "/feedback" },
  ];

  return (
    <nav className="navbar navbar-expand-lg navbar-light">
      <div className="container">
        <NavLink className="navbar-brand logo" to="/">
          Course-Win
        </NavLink>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            {navItems.map((item) => (
              <li className="nav-item" key={item.name}>
                <NavLink
                  className="nav-link"
                  to={item.path}
                  activeClassName="active"
                >
                  {item.name}
                </NavLink>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Header;
