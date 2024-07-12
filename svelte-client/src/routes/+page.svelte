<script lang="ts">
	import type { SupportRequest } from '$lib/types';
	import svgIcons from '$lib/svg-icons';
	import homeBG from '$lib/assets/home-bg.jpg';
	import { fly } from 'svelte/transition';
	import { quintOut } from 'svelte/easing';
	import { onMount } from 'svelte';

	const API_URL = 'http://localhost:8080/api/v1/supportrequests/add';

	let formData: SupportRequest = {
		email: '',
		description: '',
		dueDate: new Date().toISOString().split('T')[0],
		createdDate: new Date().toISOString().split('T')[0]
	};

	let success: boolean = false;
	let error: boolean = false;
	let pageLoaded: boolean = false;
	let responseData: any;

	const sendDataToAPI = async () => {
		const response = await fetch(API_URL, {
			method: 'POST',
			body: JSON.stringify(formData),
			headers: {
				'Content-type': 'application/json; charset=UTF-8'
			}
		});

		responseData = await response.text();

		if (response.status == 201) {
			success = true;
			error = false;
		} else {
			success = false;
			error = true;
		}
	};

	onMount(() => {
		pageLoaded = true;
	});
</script>

<svelte:head>
	<title>TSRS - Home</title>
</svelte:head>

<main class="grid grid-cols-2 w-screen h-screen">
	<div class="w-full h-auto border-r-4 border-black dark:border-white">
		<img class="w-full h-screen object-cover" src={homeBG} alt="Home Unsplash Background" />
	</div>
	{#if pageLoaded}
		<div
			class="w-10/12 mx-auto my-24"
			transition:fly={{ delay: 250, duration: 1500, x: 300, opacity: 0, easing: quintOut }}
		>
			<form on:submit={sendDataToAPI}>
				<label
					class="block mb-2 text-lg font-medium text-gray-900 dark:text-white"
					for="email-group">Your Email:</label
				>
				<div class="relative mb-8">
					<div class="absolute inset-y-0 start-0 flex items-center ps-3.5 pointer-events-none">
						{@html svgIcons.email}
					</div>
					<input
						type="email"
						id="email-group"
						name="email"
						class="bg-gray-50 border border-gray-300 text-gray-900 text-base rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-10 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
						placeholder="name@trasik.com"
						minlength="3"
						maxlength="320"
						required
						bind:value={formData.email}
					/>
				</div>
				<label
					class="block mb-2 text-lg font-medium text-gray-900 dark:text-white"
					for="description-group">Request Description:</label
				>
				<div class="relative mb-8">
					<div class="absolute inset-y-0 start-0 flex items-center ps-3.5 pointer-events-none">
						{@html svgIcons.description}
					</div>
					<textarea
						id="description-group"
						name="description"
						rows="10"
						cols="50"
						class="bg-gray-50 border border-gray-300 text-gray-900 text-base rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-10 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
						placeholder="Please enter the description of your request..."
						minlength="100"
						maxlength="1000"
						bind:value={formData.description}
						required
					/>
				</div>
				<label class="block mb-2 text-lg font-medium text-gray-900 dark:text-white" for="date-group"
					>Request Due Date:</label
				>
				<input
					class="bg-gray-50 border border-gray-300 text-gray-900 text-base rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-4 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
					type="date"
					id="date-group"
					name="dueDate"
					required
					bind:value={formData.dueDate}
				/>
				<button
					type="submit"
					class="block mx-auto my-8 bg-blue-300 dark:bg-blue-600 p-2 rounded-lg hover:bg-blue-500 dark:hover:bg-blue-500 transition"
					>Submit</button
				>
			</form>
			{#if success}
				<div
					class="relative flex justify-center"
					transition:fly={{ delay: 250, duration: 1500, x: 300, opacity: 0, easing: quintOut }}
				>
					<div
						class="absolute mt-1 bg-green-300 dark:bg-green-600 w-10/12 h-auto rounded-xl overflow-hidden"
					>
						<p class="flex text-xl font-bold p-2 justify-center">Success</p>
						<p class="px-2 py-2"><span class="font-bold pr-8">Message: </span>{responseData}</p>
					</div>
				</div>
			{:else if error}
				<div
					class="relative flex justify-center"
					transition:fly={{ delay: 250, duration: 1500, x: 300, opacity: 0, easing: quintOut }}
				>
					<div class="absolute mt-1 bg-red-300 dark:bg-red-600 w-10/12 h-[100px] rounded-xl">
						<p class="flex text-lg font-medium p-2 justify-center">Error: {responseData}</p>
					</div>
				</div>
			{/if}
		</div>
	{/if}
</main>
