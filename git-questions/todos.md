
### 1. **Branching and Merging**
- Create a feature branch from the main branch, make a code change, and merge it back using a pull request (or merge if local).
- Resolve a merge conflict between two branches.

### 2. **Commit Manipulation**
- Split a single commit into two separate commits with meaningful messages (using interactive rebase).
- Amend the most recent commit to add forgotten changes and update the commit message.

### 3. **Cherry-Picking and Reverting**
- Cherry-pick a specific commit from another branch onto the current branch.
- Revert a faulty commit, ensuring the repository returns to a working state.

### 4. **History Editing**
- Perform an interactive rebase to squash several commits into one.
- Reorder two commits in the history.

### 5. **Working with Remote Repositories**
- Add a new remote to your repository, fetch the changes, and merge a remote branch.
- Force-push a rewritten history to a remote repository (ideally in a fork or test repo to avoid disrupting existing work).

### 6. **Tagging and Releases**
- Tag a specific commit with an annotated tag and push the tag to the remote repository.
- Delete a tag both locally and on the remote.

### 7. **Handling Large Files and .gitignore**
- Add a large binary file to the repo, then configure Git LFS to track this file going forward.
- Update the .gitignore to exclude build artifacts, IDE settings, and other unnecessary files from version control.

### 8. **Recovering Lost Work**
- “Lose” a commit (delete a branch or reset), then recover it using git reflog.

### 9. **Removing Sensitive Data**
- Remove a password accidentally committed in a previous commit from the repository’s history.

### 10. **Automating Workflows with Git Hooks**
- Create a pre-commit hook that blocks commits if a file exceeds a certain size or if the commit message does not meet set standards.

