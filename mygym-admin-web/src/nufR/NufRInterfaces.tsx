

/** Interface of data passed to NUFR translated components  */
export interface ITranslationArgs {
    labelKey: string,
    replacements? : string[]
}


export interface IInputArgs extends ITranslationArgs{
    name: string,
    mandatory: boolean,
    
}

