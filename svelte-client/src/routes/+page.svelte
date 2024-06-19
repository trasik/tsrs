<script lang="ts">
	import type { SupportRequest } from '$lib/types';

	const API_URL = 'http://localhost:8080/api/v1/supportrequests/add';

	let formData: SupportRequest = {
		email: '',
		description: '',
		dueDate: new Date().toISOString().split('T')[0],
		createdDate: new Date().toISOString().split('T')[0]
	};

	const sendDataToServer = async () => {
		const response = await fetch(API_URL, {
			method: 'post',
			body: JSON.stringify(formData),
			headers: {
				'Content-type': 'application/json; charset=UTF-8'
			}
		});

		const data = response.json();
	};
</script>

<main>
	<form on:submit={sendDataToServer} method="post">
		<label for="email-group">Your Email:</label>
		<input
			type="email"
			id="email-group"
			name="email"
			placeholder="name@trasik.com"
			required
			bind:value={formData.email}
		/>
		<label for="description-group">Request Description:</label>
		<textarea
			id="description-group"
			name="description"
			rows="4"
			cols="50"
			placeholder="Please enter the description of your request..."
			minlength="100"
			maxlength="1000"
			bind:value={formData.description}
			required
		/>
		<label for="date-group">Request Due Date:</label>
		<input type="date" id="date-group" name="dueDate" required bind:value={formData.dueDate} />
		<button type="submit">Submit</button>
	</form>
</main>
