import api from '../api/api';
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Toast from '../components/Toast/Toast';

import '../style/Login.css'


export default function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const [error, setError] = useState("");

    function goToRegister(){
        navigate("/register");
    }

    async function handleLogin(e){
        e.preventDefault();

        console.log(email, password);

        if(!email.trim() || !password.trim()){
            alert("preencha os campos!");
            return;
        }

        try{
            const response = await api.post("/login", {
                email, password
            });

            const token = response.data.token;
            localStorage.setItem("token", token);

            const username = response.data.username;
            localStorage.setItem("username", username);

            navigate("/home");
        }catch(error){
            console.log("erro no login: ", error);
            setError("Usuário ou senha incorreta");
        }

    }

    return (
        <>
            {
                error && (
                    <Toast
                        message={error}
                        type="error"
                        onClose={()=> setError("")}
                    />
                )
            }

            <div className="container">
                <div className="content-card">
                    <div className="header-login">
                        <img src="src/assets/sheet.png" alt="folha" />
                        <h1>Sistema de Finanças</h1>
                        <p>Organize seus gastos e investimentos de maneira eficiente.</p>
                    </div>

                    <div className="content-login">
                        
                        <h2>Login</h2>
                        <form onSubmit={handleLogin}>
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

                            <button type="button" onClick={goToRegister}>Criar conta</button>
                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}