window.addEventListener('load', function(e) {
	console.log('Testing js')
	run();
})


let run = function(e) {
	console.log('test run')
	loadAllCompanies();
	document.addCompanyForm.submit.addEventListener('click', addCompany);
	document.updateForm.submit.addEventListener('click', updateCompany);
	aggregationData();
}


let aggregationData = function(e) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/company/search/active/true')
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let companies = JSON.parse(xhr.responseText);
				displayActiveCount(companies);
				getOffers(companies)
			}
		}


	};
	xhr.send();

}

let getOffers = function(e) {


	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/offers')
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let offers = JSON.parse(xhr.responseText);
				displayOfferCount(offers);

			}
		}


	};
	xhr.send();

}




let loadAllCompanies = function(e) {
	//XHR
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/companies')
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let compList = JSON.parse(xhr.responseText);
				displayAllCompanies(compList);
			}
		}


	};
	xhr.send();
}
let getCompany = function(id) {


	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/company/' + parseInt(id))
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let company = JSON.parse(xhr.responseText);
				displayCompany(company);
				console.log(company)
			}
		}


	};
	xhr.send();

}
let deleteCompany = function(e) {
	e.preventDefault();
	let compId = e.target.value;
	console.log(compId)

	let xhr = new XMLHttpRequest();
	xhr.open('Delete', 'api/delete/company/' + compId)
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				loadAllCompanies();
				location.reload();
			}
		}

	};
	xhr.send();
}


let addCompany = function(e) {


	e.preventDefault();
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/add/company');

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) { // Ok or Created
				let data = JSON.parse(xhr.responseText);
				displayCompany(data);
				location.reload();
			}
			else {
				console.error("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};


	let form = document.addCompanyForm;
	// JavaScript data (object)
	if (form.remote.value === 'on') {
		form.remote.value = 'true'
	} else {
		form.remote.value = 'false'
	}
	let company = {
		name: form.name.value,
		applyDate: form.applyDate.value,
		website: form.website.value,
		active: true,
		remote: form.remote.value
	}

	let companyObjectJson = JSON.stringify(company); // Convert JS object to JSON string

	// Pass JSON as request body
	xhr.send(companyObjectJson);




}


let updateCompany = function(e) {


	e.preventDefault();
	let form = document.updateForm;
	let id = form.id.value
	console.log(id)
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/update/company/' + parseInt(id));

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) { // Ok or Created
				let data = JSON.parse(xhr.responseText);
				displayCompany(data);
				location.reload();
			}
			else {
				console.error("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};



	// JavaScript data (object)
	if (form.remote.value === 'on') {
		form.remote.value = 'true'
	} else {
		form.remote.value = 'false'
	}
	let company = {
		id: id,
		name: form.name.value,
		applyDate: form.applyDate.value,
		website: form.website.value,
		active: true,
		remote: form.remote.value
	}

	let companyObjectJson = JSON.stringify(company); // Convert JS object to JSON string

	// Pass JSON as request body
	xhr.send(companyObjectJson);




}












let displayOfferCount = function(e) {
	let tbody = document.getElementById('aggCountBody')
	let tr = document.createElement('tr')
	tr.textContent = 'Total Offer Count: ';
	tbody.appendChild(tr);
	let td = document.createElement('td')
	td.textContent = e.length;
	tr.appendChild(td);


}



let displayActiveCount = function(e) {
	let tbody = document.getElementById('aggCountBody')
	let tr = document.createElement('tr')
	tr.textContent = 'Total Active Count: ';
	tbody.appendChild(tr);
	let td = document.createElement('td')
	td.textContent = e.length;
	tr.appendChild(td);


}



let displayAllCompanies = function(compList) {
	//DOM
	let tbody = document.getElementById('compListTbody')
	tbody.textContent = '';
	for (let comp of compList) {
		let tr = document.createElement('tr')
		tbody.appendChild(tr);

		tr.addEventListener('click', function(e) {
			e.preventDefault();
			let compId = e.target.parentElement.firstElementChild.textContent;
			console.log(compId);
			getCompany(compId);
		});



		let tdId = document.createElement('td');
		tdId.textContent = comp.id;
		tr.appendChild(tdId);

		td = document.createElement('td');
		td.textContent = comp.name;
		tr.appendChild(td);


	}

}



let displayCompany = function(company) {
	let tBody = document.getElementById('companyBody');
	tBody.textContent = '';
	
	let tr = document.createElement('tr')
	tr.textContent = 'Id: '
	tBody.appendChild(tr);
	let tdId = document.createElement('td')
	tdId.textContent = company.id;
	tr.appendChild(tdId);
	
	 tr = document.createElement('tr')
	tr.textContent = 'Name: '
	tBody.appendChild(tr);
	let tdName = document.createElement('td')
	tdName.textContent = company.name;
	tr.appendChild(tdName);

	tr = document.createElement('tr')
	tr.textContent = 'Date Applied: '
	tBody.appendChild(tr);
	let tdApplyDate = document.createElement('td');
	tdApplyDate.textContent = company.applyDate;
	tr.appendChild(tdApplyDate);

	tr = document.createElement('tr')
	tr.textContent = 'Active: '
	tBody.appendChild(tr);
	let active = document.createElement('td');
	active.textContent = company.active;
	tr.appendChild(active);

	tr = document.createElement('tr')
	tr.textContent = 'Remote: '
	tBody.appendChild(tr);
	let remote = document.createElement('td');
	remote.textContent = company.remote;
	tr.appendChild(remote);

	let remove = document.createElement('button');
	remove.textContent = "Delete"
	remove.name = 'submit';
	remove.type = 'submit';
	remove.value = company.id
	remove.addEventListener('click', deleteCompany);
	tBody.lastElementChild.appendChild(remove);



}