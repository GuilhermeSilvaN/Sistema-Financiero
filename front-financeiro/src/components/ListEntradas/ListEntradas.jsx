import {useState, useEffect} from 'react';
import api from "../../api/api";

export default function ListEntradas() {

    const [mesDashboard, setMesDashboard] = useState([]);
    const [mesSelecionado, setMesSelecionado] = useState(0);

    useEffect(() => {
        async function fetchEntradas() {
            try {
                const response = await api.get("/mesdashboard");
                setMesDashboard(response.data);

            } catch (error) {
                console.log(error);
            }
        }

        fetchEntradas();

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
        entradas = [],
        totalEntradas = 0
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
                    <h2>Entradas</h2>
                    <p>
                        Acompanhe suas Entradas e controle seus gastos
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
                        Total de Entradas no mês
                    </p>
                </div>
            </div>


            <div className="listDash">
                <h2>Lista de Entradas</h2>
                <div className="desp-item">
                    <div className="title-items">
                        <p>Data</p>
                        <p>Descrição</p>
                        <p>Valor</p>
                    </div>
                    {
                        entradas.map((entrada) => (
                            <div
                                className="title-items-entrada"
                                key={entrada.id}
                            >
                                <p>{entrada.dataEntrada}</p>
                                <p>{entrada.descricao}</p>
                                <p>R$ {entrada.valor.toFixed(2)}</p>
                            </div>
                        ))
                    }
                </div>
            </div>
        </div>
    );
}