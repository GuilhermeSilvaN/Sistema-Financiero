import './Header.css'
import { useNavigate } from 'react-router-dom';

import { useState } from "react";

export default function Header() {

    const navigate = useNavigate();

    const [menuOpen, setMenuOpen] = useState(false);

    function logout() {
        localStorage.clear();
        navigate("/");
    }

    function goToDashboard(){
        navigate("/home");
    }

    function goToEntradas(){
        navigate("/entradas");
    }

    function goToDespesas(){
        navigate("/despesas");
    }

    function goToRelatorios(){
        navigate("/relatorios");
    }

    function goToMetas(){
        navigate("/metas");
    }

    return (
        <>

            {/* NAVBAR MOBILE */}
            <div className="mobile-navbar">
                <button
                    className="menu-button"
                    onClick={() => setMenuOpen(!menuOpen)}
                >
                    ☰
                </button>
                <img
                    src="/src/assets/profile-sheet.png"
                    alt="Foto de perfil"
                    className="mobile-profile"
                />
            </div>

            {/* SIDEBAR */}
            <aside
                className={`sidebar ${menuOpen ? "open" : ""}`}
            >
                <div>
                    <div className="profile">
                        <div className="img">
                            <img
                                src="/src/assets/profile-sheet.png"
                                alt="foto de perfil folha"
                            />
                        </div>
                        <div className="content-profile">
                            <h2>Finanças</h2>
                            <p>Pessoais</p>
                        </div>
                    </div>

                    <nav className="nav-bar">
                        <button
                            type="button"
                            className="active"
                            onClick={goToDashboard}
                        >
                            <span></span>
                            Dashboard
                        </button>

                        <button 
                            type="button"
                            onClick={goToEntradas}
                        >
                            <span></span>
                            Entradas
                        </button>

                        <button 
                            type="button"
                            onClick={goToDespesas}
                        >
                            <span></span>
                            Despesas
                        </button>

                        <button type="button" onClick={goToRelatorios}>
                            <span></span>
                            Relatórios
                        </button>

                        <button type="button" onClick={goToMetas}>
                            <span></span>
                            Metas
                        </button>
                    </nav>

                </div>

                <div className="footer-sidebar">
                    <h4>
                        {localStorage.getItem("username")}
                    </h4>

                    <button
                        type="button"
                        className="logout-btn"
                        onClick={logout}
                    >
                        <span></span>
                        Sair
                    </button>
                </div>
            </aside>
        </>
    );
}