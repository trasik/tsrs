<script lang="ts">
	let filterOption: string = 'relevant';
	const API_URL = 'http://localhost:8080/api/v1/supportrequests';

	const getDataFromAPI = async () => {
		const response = await fetch(API_URL + `?option=${filterOption}`, {
			method: 'get',
			headers: {
				'Content-type': 'application/json; charset=UTF-8'
			}
		});

		const data = response.json();
	};
</script>

<h1>Requests</h1>

<select name="filterOption" id="requestFilter" bind:value={filterOption} on:change={getDataFromAPI}>
	<option value="relevant">Most Relevant</option>
	<option value="earliestDueDate">Earliest Due Date</option>
</select>
