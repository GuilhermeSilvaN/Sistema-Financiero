import './ListDashboard.css'
import {useState, useEffect } from "react";
import api from "../../api/api";

export default function ListDashboard() {

    const [mesDashboard, setMesDashboard] = useState([]);
    const [mesSelecionado, setMesSelecionado] = useState(0);

    useEffect(() => {
        async function fetchDashboard() {
            try {
                const response = await api.get("/mesdashboard");
                setMesDashboard(response.data);

            } catch (error) {
                console.log(error);
            }
        }

        fetchDashboard();

    }, []);

    // Enquanto os dados da API não chegam
    if (mesDashboard.length === 0) {
        return <p>Carregando...</p>;
    }

    // Mês atualmente selecionado
    const mesAtual = mesDashboard[mesSelecionado];

    const {
        month,
        year,
        dashboard
    } = mesAtual;

    const {
        despesas = [],
        totalDespesas = 0,
        totalEntradas = 0,
        totalSaldo = 0
    } = dashboard;

    function mesAnterior() {

        if (mesSelecionado > 0) {
            setMesSelecionado(mesSelecionado - 1);
        }
    }

    function proximoMes() {

        if (mesSelecionado < mesDashboard.length - 1) {
            setMesSelecionado(mesSelecionado + 1);
        }
    }

    return (
        <div className="main-dashboard">

            <div className="title-dash">
                <div className="title">
                    <h2>Resumo financeiro</h2>
                    <p>
                        Acompanhe suas finanças e controle seus gastos
                    </p>
                </div>

                <div className="control-date">

                    <button onClick={mesAnterior}>
                        &lt;
                    </button>

                    <button>
                        {`${month < 10 ? '0' + month : month} / ${year}`}
                    </button>

                    <button onClick={proximoMes}>
                        &gt;
                    </button>

                </div>

            </div>

            <div className="content-info-money">
                <div className="content-money">
                    <h3>Entradas</h3>
                    <div className="value">
                        <p>
                            R$ {totalEntradas.toFixed(2)}
                        </p>
                        <button>
                            X
                        </button>

                    </div>
                    <p>
                        Total de entradas no mês
                    </p>
                </div>

                <div className="content-money">
                    <h3>Despesas</h3>
                    <div className="value">
                        <p>
                            R$ {totalDespesas.toFixed(2)}
                        </p>
                        <button>
                            X
                        </button>
                    </div>

                    <p>
                        Total de despesas no mês
                    </p>
                </div>


                <div className="content-money">
                    <h3>Saldo</h3>
                    <div className="value">
                        <p>
                            R$ {totalSaldo.toFixed(2)}
                        </p>
                        <button>
                            X
                        </button>
                    </div>
                    <p>
                        Saldo total do mês
                    </p>
                </div>
            </div>


            <div className="listDash">
                <h2>Lista de despesas</h2>
                <div className="desp-item">
                    <div className="title-items">
                        <p>Data</p>
                        <p>Descrição</p>
                        <p>Categoria</p>
                        <p>Forma de pagamento</p>
                        <p>Valor</p>
                    </div>
                    {
                        despesas.map((despesa) => (

                            <div
                                className="title-items"
                                key={despesa.id}
                            >
                                <p>{despesa.dataDespesa}</p>
                                <p>{despesa.descricao}</p>
                                <p>{despesa.categoria}</p>
                                <p>{despesa.formaPagamento}</p>
                                <p>R$ {despesa.valor.toFixed(2)}</p>
                            </div>
                        ))
                    }
                </div>
            </div>
        </div>
    );
}