<script lang="ts">
	import type { SupportRequest } from '$lib/types';
	import { fly } from 'svelte/transition';
	import { quintOut } from 'svelte/easing';
	import { onMount } from 'svelte';

	let filterOption: string = 'relevant';
	const API_URL = 'http://localhost:8080/api/v1/supportrequests';

	let success: boolean = false;
	let responseData: SupportRequest[];

	const getDataFromAPI = async () => {
		APIHelper(filterOption);
	};

	const APIHelper = async (option: string) => {
		success = false;
		const response = await fetch(API_URL + `?option=${filterOption}`, {
			method: 'get',
			headers: {
				'Content-type': 'application/json; charset=UTF-8'
			}
		});

		responseData = await response.json();

		if (response.status == 200) {
			success = true;
		}
	};

	onMount(async () => {
		APIHelper('relevant');
	});
</script>

<svelte:head>
	<title>TSRS - Requests</title>
</svelte:head>

<header class="relative mt-8 flex w-full">
	<select
		class="absolute right-10 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
		name="filterOption"
		id="requestFilter"
		bind:value={filterOption}
		on:change={getDataFromAPI}
	>
		<option value="relevant">Most Relevant</option>
		<option value="earliestDueDate">Earliest Due Date</option>
	</select>
</header>

<main class="mt-8 w-11/12 h-full mx-auto mb-16">
	{#if success}
		{#each responseData as supportRequest, i}
			<div
				class="inline-block p-4 mt-8 bg-black/[0.2] dark:bg-white/[0.2] w-full h-auto rounded-xl hover:scale-105 transition"
				in:fly|global={{ delay: i * 100, duration: 1500, x: 100, opacity: 0, easing: quintOut }}
			>
				<p class="px-2"><span class="font-bold pr-8">Email: </span>{supportRequest.email}</p>
				<p class="p-2">
					<span class="font-bold pr-8">Description: </span>{supportRequest.description}
				</p>
				<p class="px-2 pb-2">
					<span class="font-bold pr-8">Due Date: </span>{supportRequest.dueDate}
				</p>
				<p class="px-2 pb-2">
					<span class="font-bold pr-8">Created Date: </span>{supportRequest.createdDate}
				</p>
			</div>
		{/each}
	{/if}
</main>
