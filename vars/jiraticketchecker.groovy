def call() {
  sh '''
        commit_msg=$(git log -1 HEAD --pretty=format:%s --no-merges)
        if grep -q ^[B][L][R]-[0-9][0-9] <<< "$commit_msg"; then
          break
        elif grep -q ^[A][T][X]-[0-9][0-9] <<< "$commit_msg"; then
            break
        elif grep -q ^[S][A][L]-[0-9][0-9] <<< "$commit_msg"; then
            break
        elif grep -q ^[D][V][O][P][S]-[0-9][0-9] <<< "$commit_msg"; then
            break
        elif grep -q ^[D][T]-[0-9][0-9] <<< "$commit_msg"; then
            break
        elif grep -q ^[D][E][F]-[0-9][0-9] <<< "$commit_msg"; then
            break
        else
                echo "FAILING BUILD: NO JIRA TICKET ID in COMMIT MESSAGE"
            exit 1
        fi
    '''

}
