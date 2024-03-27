package commands

enum class CommandType(val maker: MakerArguments<*>) {
    Add(AddArgumentsMaker()),
    Clear(WithoutArgumentMaker.get()),
    CountByNumbersOfParticipants(CountByNumbersOfParticipantsArgumentsMaker()),
    FilterByAlbumsCount(FilterByAlbumsCountArgumentsMaker()),
    Help(WithoutArgumentMaker.get()),
    Info(WithoutArgumentMaker.get()),
    RemoveAnyByFrontMan(RemoveAnyByFrontManArgumentsMaker()),
    RemoveAt(RemoveAtArgumentsMaker()),
    RemoveById(RemoveByIdArgumentsMaker()),
    Reorder(WithoutArgumentMaker.get()),
    Show(WithoutArgumentMaker.get()),
    Shuffle(WithoutArgumentMaker.get()),
    Update(UpdateArgumentsMaker()),
    Save(WithoutArgumentMaker.get()),
    Exit(WithoutArgumentMaker.get()),
    Execute(WithoutArgumentMaker.get())
}