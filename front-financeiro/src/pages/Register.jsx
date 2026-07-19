import { useState } from "react";
import { useNavigate } from "react-router-dom";

import '../style/Login.css'
import api from "../api/api";

export default function Register(){

    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    function goToLogin(){
        navigate("/");
    }

    async function handleRegister(e){
        e.preventDefault();

        const user = {
            username,
            email,
            password
        }

        console.log(user);

        if(!username.trim() || !email.trim() || !password.trim()){
            alert("preencha os campos baitola");
            return;
        }

        const isActive = true;

        try{
            // eslint-disable-next-line no-unused-vars
            const response = await api.post("/login/register", {
                username, email, password, isActive
            });

            navigate("/");
        } catch(error){
            console.log("error no login", error);
            alert("Registro invalido");
        }
    }

    return (
        <div className="container">
            <div className="content-card">
                <div className="header-login">
                    <img src="src/assets/sheet.png" alt="folha" />
                    <h1>Sistema de Finanças</h1>
                    <p>Começe a organizar seus gastos e investimentos de maneira eficiente.</p>
                </div>

                <div className="content-login">
                    
                    <h2>Cadastre-se</h2>
                    <form onSubmit={handleRegister}>

                        <input
                        type="text"
                        placeholder="Nome"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        />

                        <input
                        type="email"
                        placeholder="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        />

                        <input
                        type="text"
                        placeholder="senha"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        />

                        <button type="submit">Entrar</button>
                        
                        <button type="button" onClick={goToLogin}>Já tenho uma Conta</button>

                    </form>

                </div>
            </div>
        </div>
    )
}