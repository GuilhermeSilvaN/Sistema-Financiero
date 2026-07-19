import '../ListDashboard/ListDashboard.css'
import {useState, useEffect} from "React";
import api from "../../api/api";

export default function ListRelatorio() {
    const [mesDashboard, setMesDashboard] = useState([]);
    const [mesSelecionado, setMesSelecionado] = useState(0);

    useEffect(() => {
        async function fetchRelatorio() {
            try {
                const response = await api.get("/mesdashboard");
                setMesDashboard(response.data);
            } catch (error) {
                console.log(error);
            }
        }
        fetchRelatorio();

    }, []);

    if (mesDashboard.length === 0) {
        return <p>Carregando relatório...</p>;
    }

    const mesAtual = mesDashboard[mesSelecionado];
    const { dashboard } = mesAtual;

    const {totalDespesa, totalEntradas} = dashboard;

    return(
        <div className="main-dashboard">
            <div className="title-dash">
                <div className="title">
                    <h2>Relatório financeiro</h2>
                    <p>
                        Acompanhe suas finanças e controle seus gastos
                    </p>
                </div>
            </div>

            {
                
            }

        </div>
    )
}