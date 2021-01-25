
import { ITranslationArgs } from "../NufRInterfaces"

// const Navbar = ({ title, icon }) => {
const NufrLabel = ({ labelKey, replacements }:ITranslationArgs) => {

    return (  
        <label>
            Name:
            <input type="text" name="name" />
        </label>) ;

}