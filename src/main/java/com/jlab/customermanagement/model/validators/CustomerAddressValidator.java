package com.jlab.customermanagement.model.validators;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.jlab.customermanagement.model.Address;
import com.jlab.customermanagement.model.AddressType;

public class CustomerAddressValidator implements ConstraintValidator<CustomerAddress, Set<Address>> {

	@Override
	public boolean isValid(Set<Address> addresses, ConstraintValidatorContext context) {
		//If the address has more than 2 addresses (Mailing + Residence) then it is invalid
		if (addresses == null || addresses.size() > 2)
			return false;

		
		boolean mailingAddressFound = false, residenceAddressFound = false;

		for (Address address : addresses) {
			if (address.getType().equals(AddressType.MAIL))
				mailingAddressFound = true;

			if (address.getType().equals(AddressType.RESIDENCE))
				residenceAddressFound = true;
		}

		return (mailingAddressFound && residenceAddressFound);
	}

}
