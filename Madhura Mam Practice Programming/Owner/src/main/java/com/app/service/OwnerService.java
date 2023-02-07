package com.app.service;

import java.util.List;

import com.app.dto.OwnerDTO;
import com.app.pojos.Owner;

public interface OwnerService {
	List<Owner> getAllOwner();
	Owner addOwner(Owner own);
	void loginOwner(OwnerDTO dto);
	void deleteOwner(Long id);
}
