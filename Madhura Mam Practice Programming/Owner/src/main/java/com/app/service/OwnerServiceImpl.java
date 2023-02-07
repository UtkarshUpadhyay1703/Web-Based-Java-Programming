package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.OwnerDTO;
import com.app.pojos.Owner;
import com.app.repository.OwnerRepository;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerRepository ownRepo;
	@Override
	public List<Owner> getAllOwner() {
		return ownRepo.findAll();
	}
	@Override
	public Owner addOwner(Owner own) {
		return ownRepo.save(own);
	}
	@Override
	public void loginOwner(OwnerDTO dto) {
		ownRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
	}
	@Override
	public void deleteOwner(Long id) {
		ownRepo.deleteById(id);;
	}

}
