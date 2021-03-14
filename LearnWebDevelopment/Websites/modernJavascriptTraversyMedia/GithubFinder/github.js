class Github {
    constructor() {
        this.client_id = 'Arjunkhera';
        this.client_secret = '';
        this.repos_count = 5;
        this.repos_sort = 'created: asc';
    }

    async getUser(user) {
        const profileResponse = await fetch(this.addToken(`https://api.github.com/users/${user}?`));
        const profile = await profileResponse.json();

        const reposResponse = await fetch(this.addToken(`https://api.github.com/users/${user}/repos?per_page=${this.repos_count}&sort=${this.repos_sort}&`));
        const repos = await reposResponse.json();

        return {
            profile,
            repos
        }
    }

    addToken(baseUrl) {
        return baseUrl + `client_id=${this.client_id}&client_secret=${this.client_secret}`;
    }
}