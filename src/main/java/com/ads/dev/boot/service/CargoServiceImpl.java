package com.ads.dev.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // pacote org.springframework

import com.ads.dev.boot.dao.CargoDao;
import com.ads.dev.boot.domain.Cargo;
import com.ads.dev.boot.util.PaginacaoUtil;

@Service @Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {
	
	@Autowired
	private CargoDao cargoDao;

	@Override
	public void salvar(Cargo cargo) {
		cargoDao.save(cargo);
		
	}

	@Override
	public void editar(Cargo cargo) {
		cargoDao.update(cargo);
	}

	@Override
	public void excluir(Long id) {
		cargoDao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		
		return cargoDao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		
		return cargoDao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		if(buscarPorId(id).getFuncionarios().isEmpty()) {
			return false;
		}
		
		return true;
	}

	@Override
	public PaginacaoUtil<Cargo> buscarPorPagina(int pagina, String direcao) {
		
		return cargoDao.buscaPaginada(pagina, direcao);
	}

}
