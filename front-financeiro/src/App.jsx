import { BrowserRouter, Routes , Route} from 'react-router-dom'
import Login from './pages/Login'
import Register from './pages/Register'
import Home from './pages/Home'
import Despesas from './pages/Despesas'
import Entradas from './pages/Entradas'
import Relatorio from './pages/Relatorio'
import Metas from './pages/Metas'

function App() {
  

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/register" element={<Register/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path="/despesas" element={<Despesas/>}/>
          <Route path="/entradas" element={<Entradas/>}/>
          <Route path="/relatorios" element={<Relatorio/>}/>
          <Route path="/metas" element={<Metas/>}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
